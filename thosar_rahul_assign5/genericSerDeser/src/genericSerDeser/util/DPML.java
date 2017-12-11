package genericSerDeser.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import genericSerDeser.fileOperations.FileProcessor;
import genericSerDeser.strategy.SerStrategy;

public class DPML implements SerStrategy {
	
	public Map<String, Class<?>> dataTypes = new HashMap<String, Class<?>>();
	
	/**
	 * Constructor
	 */
	public DPML(){
		Logger.writeMessage("In DPML constructor", Logger.DebugLevel.CONSTRUCTOR);
		dataTypes.put("int", Integer.TYPE);
		dataTypes.put("Integer", Integer.class);
		dataTypes.put("byte", Byte.TYPE);
		dataTypes.put("short", Short.TYPE);
		dataTypes.put("long", Long.TYPE);
		dataTypes.put("float", Float.TYPE);
		dataTypes.put("double", Double.TYPE);
		dataTypes.put("boolean", Boolean.TYPE);
		dataTypes.put("char", Character.TYPE);
		dataTypes.put("String", String.class);
	}
	/** 
	 * <p>Method to get object details by reflection</p>
	 * @see genericSerDeser.strategy.SerStrategy#createDPMLFormat(java.lang.Object, genericSerDeser.fileOperations.FileProcessor)
	 * 
	 */
	@Override
	public void createDPMLFormat(Object firstOrSecondRef, FileProcessor fp) {
		Logger.writeMessage("DPML createDPMLFormat method called", Logger.DebugLevel.IN_MAKER);
		Class<?> ObjClass = firstOrSecondRef.getClass();
		Class<?>[] signature = new Class[1];
		try {
			Field[] privateField = ObjClass.getDeclaredFields();
			
			Logger.writeMessage("<fqn:" + ObjClass.getName() + ">", Logger.DebugLevel.FROM_RESULTS);
			fp.writeLineToFile("<fqn:" + ObjClass.getName() + ">" + "\n");
			for (int j = 0; j < privateField.length; j++) {
				signature[0] = dataTypes.get(privateField[j].getType().toString());
				String methodName = "get"+ privateField[j].getName();
				Method meth = ObjClass.getMethod(methodName);
				Object result = meth.invoke(firstOrSecondRef);
					Logger.writeMessage("<type=" + privateField[j].getType().getSimpleName()+ ", var=" + privateField[j].getName() + ", value=" + result + ">", Logger.DebugLevel.FROM_RESULTS);
					fp.writeLineToFile("<type=" + privateField[j].getType().getSimpleName()+ ", var=" + privateField[j].getName() + ", value=" + result + ">" + "\n");
			}
			Logger.writeMessage("</fqn:" + ObjClass.getName() + ">", Logger.DebugLevel.FROM_RESULTS);
			fp.writeLineToFile("</fqn:" + ObjClass.getName() + ">" + "\n");
		} catch (SecurityException | NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
			System.err.println("SecurityException raised while implementing DPML strategy");
			System.err.println("Terminating program");
			e1.printStackTrace();
		}finally{
			
		}
	}

}
