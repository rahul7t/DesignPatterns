package genericDeser.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import genericDeser.fileOperations.FileProcessor;

public class PopulateObjects {
	// Private Data members
	private Map<String, Class<?>> dataTypes = new HashMap<String, Class<?>>();
	private HashMap<Integer, First> firstObjectList;
	private HashMap<Integer, Second> secondObjectList;

	private FileProcessor fp;

	/**<p>
	 * Parameterized constructor
	 * </p>
	 * @param fp1
	 */
	public PopulateObjects(FileProcessor fp1) {
		Logger.writeMessage("In PopulateObjects constructor", Logger.DebugLevel.CONSTRUCTOR);
		this.fp = fp1;
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
		firstObjectList = new HashMap<Integer, First>();
		secondObjectList = new HashMap<Integer, Second>();

	}

	/**
	 * <p>
	 * read data member values from an inputFile and
	 * accordingly create instances of First and Second
	 * </p>
	 */
	public void deserObjects() {
		String line;
		int flag=0;
		do {
			line = fp.readLineFromFile();
			if(line==null && flag==0){
				System.err.println("File empty! Please check input file");
				System.exit(1);
			}
			if (line != null) {
				flag=1;
				// line = line.replaceAll("[^a-zA-Z0-9//.= :]", "");
				// line = line.replace("<", "");
				// line = line.replace(">", "");
				line = line.substring(1, line.length() - 1);
//				System.out.println("Line: " + line);
				if (line.toLowerCase().contains("fqn")) {
					String[] clsName = line.split(":");
//					System.out.println("Line contains FQN" + line);
					String[] fqnLine = line.split("\\.");
//					System.out.println(" " + fqnLine[0]);
//					System.out.println(" class: " + fqnLine[2]);
					if (fqnLine[2].equalsIgnoreCase("first")) {
						First fObj = new First();
						while (!line.toLowerCase().contains("/fqn")) {
							line = fp.readLineFromFile();
							// line = line.replaceAll("[^a-zA-Z0-9//.= :]", "");
							// line = line.replace("<", "");
							// line = line.replace(">", "");
							line = line.substring(1, line.length() - 1);
//							System.out.println(line);
							if (!line.toLowerCase().contains("/fqn")) {
								String[] objDetails = line.split(", "); // we get three objects details
								String[] type = objDetails[0].split("=");
								String[] var = objDetails[1].split("=");
								String[] value = objDetails[2].split("=");
								if (type.length < 2 || var.length < 2 || value.length < 2) {
									type[1] = "int";
									var[1] = "0";
									value[1] = "0";
								}
								Logger.writeMessage("Added to First Object: "+type[1] + var[1] + value[1], Logger.DebugLevel.IN_RESULTS);
								ObjectMaker(clsName[1], type[1], var[1], value[1], fObj);

							}
						}
						if (firstObjectList.get(fObj.hashCode()) == null) //new object in list, so add it
						{
							firstObjectList.put(fObj.hashCode(), fObj);
							Logger.writeMessage("Added to Second Object: "+fObj.toString(), Logger.DebugLevel.FROM_RESULTS);
						} else {
							//check if already present, and pull it from list to be updated
							First tempFirst = firstObjectList.get(fObj.hashCode());
							if (fObj.equals(tempFirst)) {
								tempFirst.incrCounter();
								Logger.writeMessage("Added to Second Object: "+tempFirst.toString(), Logger.DebugLevel.FROM_RESULTS);
							}
						}
					}
					if (fqnLine[2].equalsIgnoreCase("second")) {
						Second sObj = new Second();
						while (!line.toLowerCase().contains("/fqn")) {
							// Second sObj = new Second();
							line = fp.readLineFromFile();
							// line = line.replaceAll("[^a-zA-Z0-9//.= :]", "");
							// line = line.replace("<", "");
							// line = line.replace(">", "");
							line = line.substring(1, line.length() - 1);
//							System.out.println(line);
							if (!line.toLowerCase().contains("/fqn")) {
								String[] objDetails = line.split(", "); // we get three objects details
								String[] type = objDetails[0].split("=");
								String[] var = objDetails[1].split("=");
								String[] value = objDetails[2].split("=");
								if (type.length < 2 || var.length < 2 || value.length < 2) {
									type[1] = "int";
									var[1] = "0";
									value[1] = "0";
								}
//								System.out.println(type[1] + var[1] + value[1]);
								Logger.writeMessage("Added to Second Object: "+type[1] + var[1] + value[1], Logger.DebugLevel.IN_RESULTS);
								ObjectMaker(clsName[1], type[1], var[1], value[1], sObj);
							}
						}
						if (secondObjectList.get(sObj.hashCode()) == null) // new object in list
						{
							secondObjectList.put(sObj.hashCode(), sObj);
							Logger.writeMessage("Added to Second Object: "+sObj.toString(), Logger.DebugLevel.FROM_RESULTS);
						} else {
							Second tempSecond = secondObjectList.get(sObj.hashCode());
							if (sObj.equals(tempSecond)) {
								tempSecond.incrCounter();
								Logger.writeMessage("Added to Second Object: "+tempSecond.toString(), Logger.DebugLevel.FROM_RESULTS);
							}
						}
					}

				}
			}

		} while (line != null);
	}

	/**
	 * <p>Make object based on java reflection</p>
	 * @param clsName
	 * @param type
	 * @param var
	 * @param value
	 * @param fObj
	 */
	public void ObjectMaker(String clsName, String type, String var, String value, Object fObj) {
		Logger.writeMessage("PopulateObject Maker method called", Logger.DebugLevel.IN_MAKER);
		try {
			// System.out.println("input: "+clsName+type+var+value);
			Class<?> cls = fObj.getClass();
			Class<?>[] signature = new Class[1];
			signature[0] = dataTypes.get(type);

			String methodName = "set" + var;
			Method meth = cls.getMethod(methodName, signature);
			Object obj = cls.newInstance();
			Object[] params = new Object[1];
			params[0] = getValueType(type, value);
			Object result = meth.invoke(fObj, params);

		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			System.err.println("Please check params: "+clsName+type+var+value+fObj.toString());
			e.printStackTrace();
			System.exit(1);
		}

	}

	/**
	 * <p>function used to return object based on input type</p>
	 * @param type
	 * @param value
	 * @return object with value parsed depending on input type
	 */
	private Object getValueType(String type, String value) {
		switch (type) {
		case "int":
			try{
			return new Integer(value);
			}catch(NumberFormatException e){
				System.err.println("Number format does not match!"+value);
				e.printStackTrace();
				System.exit(1);
			}
		case "Integer":
			try{
			return new Integer(value);
			}catch(NumberFormatException e){
				System.err.println("Number format does not match!"+value);
				e.printStackTrace();
				System.exit(1);
			}
		case "byte":
			try{
			return new Byte(value);
			}catch(NumberFormatException e){
				System.err.println("Number format does not match!"+value);
				e.printStackTrace();
				System.exit(1);
			}
		case "short":
			try{
			return new Short(value);
			}catch(NumberFormatException e){
				System.err.println("Number format does not match!"+value);
				e.printStackTrace();
				System.exit(1);
			}
		case "long":
			try{
			return new Long(value);
			}catch(NumberFormatException e){
				System.err.println("Number format does not match!"+value);
				e.printStackTrace();
				System.exit(1);
			}
		case "float":
			try{
			return new Float(value);
			}catch(NumberFormatException e){
				System.err.println("Number format does not match!"+value);
				e.printStackTrace();
				System.exit(1);
			}
		case "double":
			try{
			return new Double(value);
			}catch(NumberFormatException e){
				System.err.println("Number format does not match!"+value);
				e.printStackTrace();
				System.exit(1);
			}
		case "boolean":
			try{
			return new Boolean(value);
			}catch(NumberFormatException e){
				System.err.println("Number format does not match!"+value);
				e.printStackTrace();
				System.exit(1);
			}
		case "char":
			try{
			return value.charAt(0);
			}catch(NumberFormatException e){
				System.err.println("Number format does not match!"+value);
				e.printStackTrace();
				System.exit(1);
			}
		case "String":
			try{
			return new String(value);
			}catch(NumberFormatException e){
				System.err.println("Number format does not match!"+value);
				e.printStackTrace();
				System.exit(1);
			}
		}
		return null;
	}

	/**
	 * <p>Method used to count unique and total objects in first object list</p>
	 */
	public void counterFirst() {
		// System.out.println("Into counterFirst:");
		int uniqueFirst = 0;
		int totalFirst = 0;
		uniqueFirst = firstObjectList.size();
		// System.out.println("Size First: "+uniqueFirst);

		Iterator it = firstObjectList.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			totalFirst = totalFirst + ((First) pair.getValue()).getCounter();
			// System.out.println("****"+((First)pair.getValue()).toString());
		}
		Logger.writeMessage("Number of unique First objects: "+ uniqueFirst, Logger.DebugLevel.RELEASE);
		Logger.writeMessage("Total Number of First objects: "+ totalFirst, Logger.DebugLevel.RELEASE);
	}

	/**
	 * <p>Method used to count unique and total objects in second object list</p>
	 */
	public void counterSecond() {
		// System.out.println("Into counterSecond:");
		int uniqueSecond = 0;
		int totalSecond = 0;
		uniqueSecond = secondObjectList.size();
		// System.out.println("Size Second: "+uniqueSecond);

		Iterator it = secondObjectList.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			totalSecond = totalSecond + ((Second) pair.getValue()).getCounter();
			// System.out.println("****"+((Second)pair.getValue()).toString());
		}
		Logger.writeMessage("Number of unique First objects: "+ uniqueSecond, Logger.DebugLevel.RELEASE);
		Logger.writeMessage("Total Number of First objects: "+ totalSecond, Logger.DebugLevel.RELEASE);
	}
}
