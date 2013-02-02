public class NotCompatibleException extends Exception {

	public NotCompatibleException(){
		 this("Matrices aren't compatible");
	}
	

	public NotCompatibleException(String message){
		super(message);
	}
}
