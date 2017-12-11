package genericDeser.util;

public class Second {
	//Private Data Members
	private int IntValue;
	private Integer IntegerValue;
	private String StringValue;
	private byte ByteValue;
	private short ShortValue;
	private long LongValue;
	private double DoubleValue;
	private short ShortValue2;
	private long LongValue2;
	private double DoubleValue2;
	private boolean BooleanValue;
	private char CharValue;
	private float FloatValue;
	private int counter;
	
	/**
	 *Constructor used to initialize private data members 
	 */
	public Second(){
		Logger.writeMessage("In Second constructor", Logger.DebugLevel.CONSTRUCTOR);
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
	public void setIntValue(int iIn) {
		IntValue = iIn;
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
	public void setStringValue(String sIn) {
		StringValue = sIn;
	}

	/**
	 * @param bIn
	 */
	public void setByteValue(byte bIn) {
		ByteValue = bIn;
	}

	/**
	 * @param shIn
	 */
	public void setShortValue(short shIn) {
		ShortValue = shIn;
	}

	/**
	 * @param lIn
	 */
	public void setLongValue(long lIn) {
		LongValue = lIn;
	}

	/**
	 * @param dIn
	 */
	public void setDoubleValue(double dIn) {
		DoubleValue = dIn;
	}
	
	/**
	 * @param shIn
	 */
	public void setShortValue2(short shIn) {
		ShortValue2 = shIn;
	}

	/**
	 * @param lIn
	 */
	public void setLongValue2(long lIn) {
		LongValue2 = lIn;
	}

	/**
	 * @param dIn
	 */
	public void setDoubleValue2(double dIn) {
		DoubleValue2 = dIn;
	}

	/**
	 * @param bIn
	 */
	public void setBooleanValue(boolean bIn) {
		BooleanValue = bIn;
	}

	/**
	 * @param cIn
	 */
	public void setCharValue(char cIn) {
		CharValue = cIn;
	}

	/**
	 * @param fIn
	 */
	public void setFloatValue(float fIn) {
		FloatValue = fIn;
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
		Second other = (Second) obj;
		if (IntValue != other.IntValue)
			return false;
		if (IntegerValue!= other.IntegerValue)
			return false;
		if (StringValue == null) {
			if (other.StringValue != null)
				return false;
		} else if (!StringValue.equals(other.StringValue))
			return false;
		if(Byte.toUnsignedInt(ByteValue) != Byte.toUnsignedInt(other.ByteValue))
			return false;
		if(Short.toUnsignedInt(ShortValue) !=Short.toUnsignedInt(other.ShortValue)){
			return false;
		}
		if(Long.toUnsignedString(LongValue).hashCode() != Long.toUnsignedString(other.LongValue).hashCode()){
			return false;
		}
		if(Double.toString(DoubleValue).hashCode() != Double.toString(other.DoubleValue).hashCode()){
			return false;
		}
		if(Short.toUnsignedInt(ShortValue2) !=Short.toUnsignedInt(other.ShortValue2)){
			return false;
		}
		if(Long.toUnsignedString(LongValue2).hashCode() != Long.toUnsignedString(other.LongValue2).hashCode()){
			return false;
		}
		if(Double.toString(DoubleValue2).hashCode() != Double.toString(other.DoubleValue2).hashCode()){
			return false;
		}
		if(Boolean.toString(BooleanValue).hashCode()!=Boolean.toString(other.BooleanValue).hashCode()){
			return false;
		}
		if(Character.toString(CharValue).hashCode()!=Character.toString(other.CharValue).hashCode()){
			return false;
		}
		if (Float.floatToIntBits(FloatValue) != Float.floatToIntBits(other.FloatValue))
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
	        result = 31 * result + Short.toUnsignedInt(ShortValue2);
	        result = 31 * result + Long.toUnsignedString(LongValue2).hashCode();
	        result = 31 * result + Double.toString(DoubleValue2).hashCode();
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
		return "Second [IntValue=" + IntValue + ", IntegerValue=" + IntegerValue + ", StringValue=" + StringValue
				+ ", ByteValue=" + ByteValue + ", ShortValue=" + ShortValue + ", LongValue=" + LongValue
				+ ", DoubleValue=" + DoubleValue + ", BooleanValue=" + BooleanValue + ", CharValue=" + CharValue
				+ ", FloatValue=" + FloatValue + ", counter=" + counter + "]";
	}
	
	
}

