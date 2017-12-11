package genericSerDeser.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import genericSerDeser.fileOperations.FileProcessor;
import genericSerDeser.strategy.SerStrategy;

public class PopulateObjects {
	// Private Data members
	private Map<String, Class<?>> dataTypes = new HashMap<String, Class<?>>();
	private List<Object> FSObjectList = new ArrayList<Object>();
	private FileProcessor fp;

	/**
	 * <p>
	 * Parameterized constructor
	 * </p>
	 * 
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
	}

	/**
	 * <p>
	 * read data member values from an inputFile and accordingly create
	 * instances of First and Second
	 * </p>
	 */
	public void deserObjects() {
		String line;
		int flag = 0;
		do {
			line = fp.readLineFromFile();
			if (line == null && flag == 0) {
				System.err.println("File empty! Please check input file");
				System.exit(1);
			}
			if (line != null) {
				flag = 1;
				line = line.substring(1, line.length() - 1);
				if (line.toLowerCase().contains("fqn")) {
					String[] clsName = line.split(":");
					Class<?> cls = null;
					Object obj = null;
					try {
						cls = Class.forName(clsName[1]);
						obj = cls.newInstance();
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} finally {

					}
					while (!line.toLowerCase().contains("/fqn")) {
						line = fp.readLineFromFile();
						line = line.substring(1, line.length() - 1);

						if (!line.toLowerCase().contains("/fqn")) {
							String[] objDetails = line.split(", ");
							// we get three objects details
							String[] type = objDetails[0].split("=");
							String[] var = objDetails[1].split("=");
							String[] value = objDetails[2].split("=");
							if (type.length < 2 || var.length < 2 || value.length < 2) {
								type[1] = "int";
								var[1] = "0";
								value[1] = "0";
							}
							try {

								Class<?>[] signature = new Class[1];
								signature[0] = dataTypes.get(type[1]);
								String methodName = "set" + var[1];
								Method meth = cls.getMethod(methodName, signature);
								Object[] params = new Object[1];
								params[0] = getValueType(type[1], value[1]);
								meth.invoke(obj, params);

							} catch (NoSuchMethodException | SecurityException | IllegalAccessException
									| IllegalArgumentException | InvocationTargetException e) {
								System.err.println("Please check params: " + clsName[1] + type[1] + var[1] + value[1]);
								System.err.println("Terminating program");
								e.printStackTrace();
								System.exit(1);
							} finally {

							}
						}
					}
					if (FSObjectList != null) {
						Logger.writeMessage("Added to Object list: " + obj, Logger.DebugLevel.IN_RESULTS);
						FSObjectList.add(obj);
					}
				}
			}

		} while (line != null);
		Logger.writeMessage("Object List Size: " + FSObjectList.size(), Logger.DebugLevel.IN_RESULTS);
	}

	/**
	 * <p>
	 * function used to return object based on input type
	 * </p>
	 * 
	 * @param type
	 * @param value
	 * @return object with value parsed depending on input type
	 */
	private Object getValueType(String type, String value) {
		try {
			switch (type) {
			case "int":
				return new Integer(value);
			case "Integer":
				return new Integer(value);
			case "byte":
				return new Byte(value);
			case "short":
				return new Short(value);
			case "long":
				return new Long(value);
			case "float":
				return new Float(value);
			case "double":
				return new Double(value);
			case "boolean":
				return new Boolean(value);
			case "char":
				return value.charAt(0);
			case "String":
				return new String(value);
			}
		} catch (NumberFormatException e) {
			System.err.println("Number format does not match!" + value);
			System.err.println("Terminating program");
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
		return null;
	}

	/***
	 * <p>
	 * Method to deserialize object
	 * </p>
	 * 
	 * @param outfile
	 * @param strategy
	 */
	public void serDeserObjects(String outfile, SerStrategy strategy) {
		Logger.writeMessage("PopulateObject serDeserObjects method called", Logger.DebugLevel.IN_MAKER);
		FileProcessor fp2 = new FileProcessor(outfile, "out");
		for (Object temp : FSObjectList) {
			strategy.createDPMLFormat(temp, fp2);
		}
		fp2.closeFile();
	}
}