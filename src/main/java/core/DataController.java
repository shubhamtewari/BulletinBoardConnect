package core;

import java.io.File;

public interface DataController {
    File saveAsFile(Object object, File path) throws Exception;
    Object loadAsObject(File file) throws Exception;
}
