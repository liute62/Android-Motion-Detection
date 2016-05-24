package haodong.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import haodong.exception.ExceptionLog;

public class FileUtil {
	
	public static final String TAG = "";
	
	public FileUtil() {
		
	}
	
    public boolean checkDirExist(String basePath,String dirName){
        File f = new File(basePath +dirName);
        if(f.isDirectory()){
            return true;
        }
        return false;
    }
    
    public static boolean deleteDirectory(File directory) {
        if(directory.exists()){
            File[] files = directory.listFiles();
            if(null != files){
                for(int i = 0; i< files.length; i++) {
                    if(files[i].isDirectory()) {
                        deleteDirectory(files[i]);
                    }
                    else {
                        files[i].delete();
                    }
                }
            }
        }
        return(directory.delete());
    }

    public String makeDirByPath(String path){
        String dir = null;
        try {
            final File f = new File(path);
            if(!f.exists())
                if (f.mkdirs())
                    dir = f.getPath();
        }catch (Exception e){
        	ExceptionLog.saveErrorMsg(TAG, "makeDirByPath", e.toString());
        }
        return dir;
    }

	public List<String> readFile(String filePath, String fileName) {
		fileName = filePath + fileName;
		List<String> lines = new ArrayList<>();
		String line = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
			line = br.readLine();
			while (line != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return lines;
	}
	
	public void writeFileFromAbPath(String fileAbPathName,String content,boolean isAppend){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream(new File(fileAbPathName), isAppend)); // true: append
            if (writer != null){
                writer.println(content);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(writer != null)
                writer.close();
        }
    }
}
