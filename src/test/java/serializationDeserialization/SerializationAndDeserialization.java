package serializationDeserialization;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Test1 implements Serializable
{
	int i=10, j=20; 
}


public class SerializationAndDeserialization {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
	
	Test1 t1 = new Test1();
	
	// Serialization
	FileOutputStream fos = new FileOutputStream("test.txt");	// help to write the file in memory
	ObjectOutputStream oos = new ObjectOutputStream(fos);		// help to convert the object in file type
	
	oos.writeObject(t1);  // help to convert the object in file format
	
	// De-Serialization
	FileInputStream fis = new FileInputStream("test.txt");
	ObjectInputStream ois = new ObjectInputStream(fis);
	
	Test1 t2 = (Test1)ois.readObject();
	System.out.println(t2.i + "  " + t2.j);
	
	}

}
