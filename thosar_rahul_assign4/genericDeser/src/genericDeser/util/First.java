package genericDeser.util;

public class First {
	//Private Data members
	private int IntValue;
	private Integer IntegerValue;
	private String StringValue;
	private byte ByteValue;
	private short ShortValue;
	private long LongValue;
	private double DoubleValue;
	private boolean BooleanValue;
	private char CharValue;
	private float FloatValue;
	private int counter;
	
	/**
	 *Constructor used to initialize private data members 
	 */
	public First(){
		Logger.writeMessage("In First object constructor", Logger.DebugLevel.CONSTRUCTOR);
		this.counter=1;
		this.IntValue=0;
		this.IntegerValue=0;
		this.StringValue=null;
		this.ByteValue=0;
		this.ShortValue=0;
		this.LongValue=0;
		this.DoubleValue=0;
		this.BooleanValue=false;
		this.CharValue='0';
		this.FloatValue=0;
	}
	
	/**
	 * @param iIn
	 */
	public void setIntValue(int iIn){
		this.IntValue = iIn;
	}
	/**
	 * @param iIn
	 */
	public void setIntegerValue(Integer iIn){
		this.IntegerValue = iIn;
	}
	/**
	 * @param sIn
	 */
	public void setStringValue(String sIn){
		this.StringValue = sIn;
	}
	/**
	 * @param bIn
	 */
	public void setByteValue(byte bIn){
		this.ByteValue = bIn;
	}
	/**
	 * @param lIn
	 */
	public void setLongValue(long lIn){
		this.LongValue = lIn;
	}
	/**
	 * @param shIn
	 */
	public void setShortValue(short shIn){
		this.ShortValue= shIn;
	}
	/**
	 * @param dIn
	 */
	public void setDoubleValue(double dIn){
		this.DoubleValue= dIn;
	}
	/**
	 * @param fIn
	 */
	public void setFloatValue(float fIn){
		this.FloatValue = fIn;
	}
	/**
	 * @param cIn
	 */
	public void setCharValue(char cIn){
		this.CharValue = cIn;
	}
	/**
	 * @param bIn
	 */
	public void setBooleanValue(boolean bIn){
		this.BooleanValue = bIn;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		First temp = (First) obj;
		if (IntValue != temp.IntValue)
			return false;
		if (IntegerValue!= temp.IntegerValue)
			return false;
		if (StringValue == null) {
			if (temp.StringValue != null)
				return false;
		} else if (!StringValue.equals(temp.StringValue))
			return false;
		if(Byte.toUnsignedInt(ByteValue) != Byte.toUnsignedInt(temp.ByteValue))
			return false;
		if(Short.toUnsignedInt(ShortValue) !=Short.toUnsignedInt(temp.ShortValue)){
			return false;
		}
		if(Long.toUnsignedString(LongValue).hashCode() != Long.toUnsignedString(temp.LongValue).hashCode()){
			return false;
		}
		if(Double.toString(DoubleValue).hashCode() != Double.toString(temp.DoubleValue).hashCode()){
			return false;
		}
		if(Boolean.toString(BooleanValue).hashCode()!=Boolean.toString(temp.BooleanValue).hashCode()){
			return false;
		}
		if(Character.toString(CharValue).hashCode()!=Character.toString(temp.CharValue).hashCode()){
			return false;
		}
		if (Float.floatToIntBits(FloatValue) != Float.floatToIntBits(temp.FloatValue))
			return false;
		return true;
	}
	 /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * @return int
	 */
	@Override
	    public int hashCode() {
	        int result = 17;
	    	result = 31 * result + IntValue;
	    	result = 31 * result + IntegerValue;
	    	result = 31 * result + ((StringValue == null) ? 0 : StringValue.hashCode());
	        result = 31 * result + Byte.toUnsignedInt(ByteValue);
	        result = 31 * result + Short.toUnsignedInt(ShortValue);
	        result = 31 * result + Long.toUnsignedString(LongValue).hashCode();
	        result = 31 * result + Double.toString(DoubleValue).hashCode();
	        result = 31 * result + Boolean.toString(BooleanValue).hashCode();
	        result = 31 * result + Character.toString(CharValue).hashCode();
	        result = 31 * result + Float.floatToIntBits(FloatValue);
	        return result;
	    }

	/**
	 * @return
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * 
	 */
	public void incrCounter() {
		this.counter++;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * @return string
	 */
	@Override
	public String toString() {
		return "First [IntValue=" + IntValue + ", IntegerValue=" + IntegerValue + ", StringValue=" + StringValue
				+ ", ByteValue=" + ByteValue + ", ShortValue=" + ShortValue + ", LongValue=" + LongValue
				+ ", DoubleValue=" + DoubleValue + ", BooleanValue=" + BooleanValue + ", CharValue=" + CharValue
				+ ", FloatValue=" + FloatValue + ", counter=" + counter + "]";
	}
	
	
}
