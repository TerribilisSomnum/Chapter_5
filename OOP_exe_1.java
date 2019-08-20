package by.etc.somnum;

//Создать объект класса Текстовый файл, используя классы Файл, Директория.
// Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.

class Directory {

    String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Directory(String path) {
        this.setPath(path);
    }
}

class File {

    private boolean isCreated;
    private Directory directory;
    private String name;
    private String extension;

    public boolean isCreated() {
        return isCreated;
    }

    public void setCreated(boolean created) {
        isCreated = created;
    }

        public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if (name.length() > 0) {
            this.name = name;
        } else {
            System.out.println("Имя файла не может быть нулевым");
        }
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {

        if (extension.length() > 0) {
            this.extension = extension;
        } else {
            System.out.println("Имя файла не может быть нулевым");
        }
    }

    public File(){

        this.setCreated(false);
        this.setName("test");
        this.setExtension("txt");
        this.setDirectory(new Directory("C:\\"));
    }

    public File(String name, String extension, Directory directory) {

        this.setCreated(false);
        this.setName(name);
        this.setExtension(extension);
        this.setDirectory(directory);
    }

    public void create() {

        this.setCreated(true);
        System.out.println("Файл создан");
    }

    public void delete() {

        this.setCreated(false);
        System.out.println("Файл удален");
    }

    public void rename(String str) {

        this.setName(str);
    }

    public void printToConsole() {

        System.out.println("Абстрактный класс не содержит данных");
    }

    public void append(String str) {

        System.out.println("Абстрактный класс как бы дополнен");
    }
}

class TextFile extends File{

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void append(String str){
        this.setContent(this.getContent() + str);
    }

    @Override
    public void printToConsole() {
        System.out.println("Содержимое файла " + this.getContent());
    }
}

public class OOP_exe_1 {

    public static void main(String[] args) {

        System.out.println("Работа представлена с классом Файл");
        File file = new File();
        file.setName("Бублики");
        file.setExtension("Вкусно");
        file.setCreated(true);
        file.setDirectory(new Directory("D:\\"));

        file.append("Hi");
        file.printToConsole();

        System.out.println("\nРабота представлена с классом ТекстФайл");
        TextFile textFile = new TextFile();
        textFile.setContent("Hello world");
        textFile.append(" I love you!");
        textFile.printToConsole();
    }
}
