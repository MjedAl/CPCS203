
public class MaterialNotFoundException extends Exception{
    
    String title;

    public MaterialNotFoundException(String title) {
        this.title = title;
    }

    @Override
    public String toString(){
        return "\r\nMaterialNotFoundException: Error: The material titled "+title+" was not found in this Book Bank.";
    }
}
