package Classes;

import java.util.*;

public class Administrator{
	
	public boolean checkAdmin(String name, String pass){
				
		String defUser = "admin";
		String defPass = "@dm1n";
				
		if (defUser.equals(name) && defPass.equals(pass)) {
                    return true;
		}
        return false;
        }
}