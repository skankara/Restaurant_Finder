/*package util.user;
 
//import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList; 
import java.util.List; 

public class UserDao {
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		
		List<User> l_userList = null ;
		try { 
	         File file = new File("Users.dat"); 
	         if (!file.exists()) { 
	            User user = new User(1, "Mahesh", "Teacher"); 
	            l_userList = new ArrayList<User>(); 
	            l_userList.add(user); 
	            saveUserList(l_userList); 
	         }
	         else{ 
	             FileInputStream fis = new FileInputStream(file); 
	             ObjectInputStream ois = new ObjectInputStream(fis); 
	             l_userList = (List<User>)ois.readObject(); 
	             ois.close(); 
	          }
		} catch (IOException e) { 
	         e.printStackTrace(); 
	      } catch (ClassNotFoundException e) { 
	         e.printStackTrace(); 
	      }   
		
		return l_userList ;
	}
	
	private void saveUserList(List<User> userList){ 
	      try { 
	         File file = new File("Users.dat"); 
	         FileOutputStream fos;  
	         fos = new FileOutputStream(file); 
	         ObjectOutputStream oos = new ObjectOutputStream(fos); 
	         oos.writeObject(userList); 
	         oos.close(); 
	      } catch (FileNotFoundException e) { 
	         e.printStackTrace(); 
	      } catch (IOException e) { 
	         e.printStackTrace(); 
	      } 
	   }   
}
*/