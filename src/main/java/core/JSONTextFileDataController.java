package core;

import com.google.gson.Gson;

import java.io.*;

public class JSONTextFileDataController implements DataController{
    @Override
    public File saveAsFile(Object object, File path) throws Exception {
        Gson gson = new Gson();
        String string = gson.toJson(object);
        //save for the software
        //File file = new File("./Saved Boards");
        //path.setWritable(false);
        FileWriter fileWriter = new FileWriter(path);
        try {
            fileWriter.write(string);
        }catch (IOException i) {
            throw i;
        }finally {
            fileWriter.close();
        }
        return path;
    }

    @Override
    public BoardStructure loadAsObject(File file) throws Exception {
        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                stringBuilder.append(s);
            }
        }catch (IOException i) {
            throw i;
        }finally {
            bufferedReader.close();
        }
        BoardStructure boardStructure = gson.fromJson(stringBuilder.toString(), BoardStructure.class);
        return boardStructure;
    }
}
