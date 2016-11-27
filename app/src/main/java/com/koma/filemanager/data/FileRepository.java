package com.koma.filemanager.data;

import com.koma.filemanager.FilemanagerApplication;
import com.koma.filemanager.data.model.AudioFile;
import com.koma.filemanager.data.model.ImageFile;
import com.koma.filemanager.data.model.VideoFile;

import java.util.ArrayList;

import rx.Observable;

/**
 * Created by koma on 11/25/16.
 */

public class FileRepository implements FileDataSource {
    private static volatile FileRepository sRespository;
    private LocalDataSource mLocalDataSource;

    private FileRepository() {
        mLocalDataSource = new LocalDataSource(FilemanagerApplication.getContext());
    }

    public static FileRepository getInstance() {
        if (sRespository == null) {
            synchronized (FileRepository.class) {
                if (sRespository == null) {
                    sRespository = new FileRepository();
                }
            }
        }
        return sRespository;
    }

    @Override
    public Observable<String> getAuidoCounts() {
        return mLocalDataSource.getAuidoCounts();
    }

    @Override
    public Observable<String> getVideoCounts() {
        return mLocalDataSource.getVideoCounts();
    }

    @Override
    public Observable<String> getImageCounts() {
        return mLocalDataSource.getImageCounts();
    }

    @Override
    public Observable<String> getDocumentsCounts() {
        return mLocalDataSource.getDocumentsCounts();
    }

    @Override
    public Observable<String> getZipCounts() {
        return mLocalDataSource.getZipCounts();
    }

    @Override
    public Observable<String> getApkCounts() {
        return mLocalDataSource.getApkCounts();
    }

    @Override
    public Observable<ArrayList<AudioFile>> getAudioFiles() {
        return mLocalDataSource.getAudioFiles();
    }

    @Override
    public Observable<ArrayList<ImageFile>> getImageFiles() {
        return mLocalDataSource.getImageFiles();
    }

    @Override
    public Observable<ArrayList<VideoFile>> getVideoFiles() {
        return mLocalDataSource.getVideoFiles();
    }
}