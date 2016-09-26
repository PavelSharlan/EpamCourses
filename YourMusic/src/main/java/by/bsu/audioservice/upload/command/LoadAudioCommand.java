package by.bsu.audioservice.upload.command;

import by.bsu.audioservice.entity.Audio;
import by.bsu.audioservice.exception.LogicException;
import by.bsu.audioservice.exception.TechnicalException;
import by.bsu.audioservice.logic.ShowAllAudioLogic;
import by.bsu.audioservice.upload.logic.LoadAudioLogic;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 7 on 02.09.2016.
 */
public class LoadAudioCommand {
    private static final String AUDIO = "audio";
    private static final String AUDIOS = "audios";
    private static final String DEMO = "demo";
    private static final String AUDIO_NAME = "audio_name";
    private static final String SINGER = "singer";
    private static final String GENRE = "genre";
    private static final String PRICE = "price";
    private static final String ERROR = "error";

    public void execute(HttpServletRequest request) {
        List<FileItem> items = null;
        String audioName = null;
        String singer = null;
        String price = null;
        String genre = null;
        String audioURL = null;
        String demoAudioUrl = null;
        try {
            items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            if (items.size() == 5) {
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        String fieldName = item.getFieldName();
                        if (fieldName.equals(AUDIO_NAME)) {
                            audioName = item.getString();
                        } else if (fieldName.equals(SINGER)) {
                            singer = item.getString();
                        } else if (fieldName.equals(GENRE)) {
                            genre = item.getString();
                        } else if (fieldName.equals(PRICE)) {
                            price = item.getString();
                        }
                    } else {
                        String fieldName = item.getFieldName();
                        String fileName = FilenameUtils.getName(item.getName());
                        String filePath = request.getServletContext().getRealPath("/") + AUDIO;
                        if (fieldName.equals(AUDIO)) {
                            filePath = filePath + File.separator + fileName;
                            audioURL = AUDIO + File.separator + fileName;
                        } else {
                            filePath = filePath + File.separator + DEMO + File.separator + fileName;
                            demoAudioUrl = AUDIO + File.separator + DEMO + File.separator + fileName;
                        }
                        File storeFile = new File(filePath);
                        try {
                            item.write(storeFile);
                        } catch (Exception e) {
                            request.setAttribute(ERROR, "Something is wrong in uploading");
                        }
                    }
                }
                LoadAudioLogic.loadAudio(singer, audioName, audioURL, price, genre, demoAudioUrl);
                ArrayList<Audio> audios = ShowAllAudioLogic.getAllAudios();
                request.getSession().setAttribute(AUDIOS, audios);
            } else {
                request.setAttribute(ERROR, "There is too little information about audio");
            }

        } catch (FileUploadException e) {
            request.setAttribute(ERROR, "FileUploadException in uploading");
        } catch (TechnicalException e) {
            request.setAttribute(ERROR, "TechnicalException in uploading");
        } catch (LogicException e) {
            request.setAttribute(ERROR, e.getMessage());
        }
    }
}
