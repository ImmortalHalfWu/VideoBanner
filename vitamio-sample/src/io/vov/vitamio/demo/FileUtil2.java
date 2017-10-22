package io.vov.vitamio.demo;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * 文件操作类
 * Created by Administrator on 2016/11/22.
 */
public class FileUtil2 {

    /**
     * 单例
     */
    private static FileUtil2 mFileUtil;

    /**
     * 分隔符
     */
    private static String SEPARATOR = File.separator;

    /**
     * 项目文件夹地址
     */
    private static String APP_FILE_PATH;

    /**
     * 错误日志
     */
    private static String APP_ERRO_FILE_PATH;
    private final static String FILE_NAME_ERRO = "Erro";
    /**
     * 文档
     */
    private static String APP_WORD_FILE_PATH;
    private final static String FILE_NAME_WORD = "Word";

    /**
     * 图片
     */
    private static String APP_IMG_FILE_PATH;
    private final static String FILE_NAME_IMG = "Image";
    /**
     * 录像
     */
    private static String APP_VIDIO_FILE_PATH;
    private final static String FILE_NAME_VIDIO = "Vidio";

    /**
     * 缓存
     */
    private static String APP_CACHE_FILE_PATH;
    private final static String FILE_NAME_CACHE = "Cache";
    /**
     * 图像缓存
     */
    private static String APP_CACHE_IMG_PATH = "";
    private final static String FILE_NAME_CACHE_IMG = "ImageCache";


    private FileUtil2(Context context) {
        initPath(context);
        initDirs();
    }

    public static FileUtil2 getInstance() {
        return mFileUtil;
    }


    public static FileUtil2 instance(Context context) {

        if (mFileUtil == null) {
            mFileUtil = new FileUtil2(context);
        }
        return mFileUtil;
    }

    private void initPath(Context context) {

        StringBuilder mFilePathBf = new StringBuilder(
                Environment
                        .getExternalStorageDirectory()
                        .getAbsolutePath()
        );

        APP_FILE_PATH = mFilePathBf.append(SEPARATOR).append(context.getPackageName()).append(SEPARATOR).toString();

        APP_ERRO_FILE_PATH =
                mFilePathBf.append(FILE_NAME_ERRO).append(SEPARATOR).toString();

        APP_WORD_FILE_PATH =
                mFilePathBf.replace(APP_FILE_PATH.length(), APP_ERRO_FILE_PATH.length(), FILE_NAME_WORD)
                        .append(SEPARATOR)
                        .toString();

        APP_IMG_FILE_PATH =
                mFilePathBf.replace(APP_FILE_PATH.length(), APP_WORD_FILE_PATH.length(), FILE_NAME_IMG)
                        .append(SEPARATOR)
                        .toString();

        APP_VIDIO_FILE_PATH =
                mFilePathBf.replace(APP_FILE_PATH.length(), APP_IMG_FILE_PATH.length(), FILE_NAME_VIDIO)
                        .append(SEPARATOR)
                        .toString();

        APP_CACHE_FILE_PATH =
                mFilePathBf.replace(APP_FILE_PATH.length(), APP_IMG_FILE_PATH.length(), FILE_NAME_CACHE)
                        .append(SEPARATOR)
                        .toString();

        APP_CACHE_IMG_PATH =
                mFilePathBf.replace(APP_FILE_PATH.length(), APP_IMG_FILE_PATH.length(), FILE_NAME_CACHE_IMG)
                        .append(SEPARATOR)
                        .toString();

    }


    private void initDirs() {

        dirsMake(APP_ERRO_FILE_PATH);
        dirsMake(APP_WORD_FILE_PATH);
        dirsMake(APP_CACHE_FILE_PATH);
        dirsMake(APP_IMG_FILE_PATH);
        dirsMake(APP_VIDIO_FILE_PATH);
        dirsMake(APP_CACHE_IMG_PATH);

    }

    /**
     * 根据路径，创建文件夹
     *
     * @param dirPath 文件夹路径
     */
    public static boolean dirsMake(String dirPath) {
        File file = new File(dirPath);
        return !file.exists() && file.mkdirs();
    }

    /**
     * 根据路径，创建文件
     *
     * @param filePath 文件路径
     */
    public static boolean fileMake(String filePath) throws IOException {
        File file = new File(filePath);
        return !file.exists() && file.createNewFile();
    }

    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.delete();
    }


    public static String getAppFilePath() {
        return APP_FILE_PATH;
    }

    public static String getAppErroFilePath() {
        return APP_ERRO_FILE_PATH;
    }

    public static String getAppWordFilePath() {
        return APP_WORD_FILE_PATH;
    }

    public static String getAppImgFilePath() {
        return APP_IMG_FILE_PATH;
    }

    public static String getAppVidioFilePath() {
        return APP_VIDIO_FILE_PATH;
    }

    public static String getAppCacheFilePath() {
        return APP_CACHE_FILE_PATH;
    }

    public static String getAppCacheImgPath() {
        return APP_CACHE_IMG_PATH;
    }

}
