package CCG;

public class Utility {

	public static String getSubnetMask (int subnet) {
		String s="";
		for (int i=0;i<subnet;i++) s+="1";
		for (int i=0;i<32;i++) s+="0";
		
		String returnS=Integer.parseInt(s.substring(0,8),2)+"."+Integer.parseInt(s.substring(8,16),2)+"."+Integer.parseInt(s.substring(16,24),2)+"."+Integer.parseInt(s.substring(24,32),2);
		return returnS;
	}
	
	public static String getWildcardMask (int subnet) {
		String subnetMask="";
		for (int i=0;i<subnet;i++) subnetMask+="1";
		for (int i=0;i<32;i++) subnetMask+="0";
		
		String wildcardMask="";
		for (int i=0;i<subnetMask.length();i++) {
			if (subnetMask.charAt(i)=='0') {
				wildcardMask+="1";
			} else if (subnetMask.charAt(i)=='1') {
				wildcardMask+="0";
			} else {
				wildcardMask+=subnetMask.charAt(i);
			}
		}
		
		String returnS=Integer.parseInt(wildcardMask.substring(0,8),2)+"."+Integer.parseInt(wildcardMask.substring(8,16),2)+"."+Integer.parseInt(wildcardMask.substring(16,24),2)+"."+Integer.parseInt(wildcardMask.substring(24,32),2);
		return returnS;
	}
	
	public static boolean [] getSubnetBits (int subnet) {
		boolean [] bits=new boolean [32];
		for (int i=0;i<subnet;i++) bits[i]=true;
		return bits;
	}
	
	public static boolean [] getSubnetBitsV6 (int subnet) {
		boolean [] bits=new boolean [128];
		for (int i=0;i<subnet;i++) bits[i]=true;
		return bits;
	}
	
	public static String getSubnetAddress (String hostAdd, int subnet) {
		String [] split=hostAdd.split("\\.");
		boolean [] bits=new boolean [32];
		for (int i=0;i<4;i++) {
			String bin=Integer.toBinaryString(Integer.parseInt(split[i]));
			while (bin.length()<8) bin="0"+bin;
			for (int i2=0;i2<8;i2++) {
				bits[i*8+i2]=(bin.charAt(i2)=='1');
			}
		}
		
		
		boolean [] subnetBits=getSubnetBits(subnet);
		boolean [] result=new boolean [32];
		for (int i=0;i<32;i++) {
			result[i]=bits[i] && subnetBits[i];
		}
		
		String s="";
		for (int i=0;i<32;i++) {
			if (result[i]) s+="1"; else s+="0";
		}

		String returnS=Integer.parseInt(s.substring(0,8),2)+"."+Integer.parseInt(s.substring(8,16),2)+"."+Integer.parseInt(s.substring(16,24),2)+"."+Integer.parseInt(s.substring(24,32),2);
		return returnS;
	}
	
	public static String getSubnetAddressV6 (String hostAdd, int subnet) {
		hostAdd=hostAdd.replace("::",":0:");
		String [] split=hostAdd.split(":");
		for (int i=0;i<8-split.length;i++) {
			hostAdd=hostAdd.replaceFirst(":0:",":0:0:");
		}
		split=hostAdd.split(":");

		boolean [] bits=new boolean [128];
		int count=0;
		for (int i=0;i<split.length;i++) {
			String decimal=split[i];
			while (decimal.length()<4) decimal="0"+decimal;
			for (int i2=0;i2<4;i2++) {
				String binary=Integer.toBinaryString(Integer.parseInt(decimal.charAt(i2)+"",16));
				while (binary.length()<4) binary="0"+binary;
				for (int i3=0;i3<4;i3++) {
					bits[count++]=(binary.charAt(i3)=='1');
				}
			}
		}
		

		boolean [] subnetBits=getSubnetBitsV6(subnet);
		boolean [] result=new boolean [128];
		for (int i=0;i<128;i++) {
			result[i]=bits[i] && subnetBits[i];
		}
		
		String s="";
		for (int i=0;i<128;i++) {
			if (result[i]) s+="1"; else s+="0";
		}

		String returnS="";
		for (int i=0;i<8;i++) {
			returnS+=Integer.toHexString(Integer.parseInt(s.substring(i*16,(i+1)*16),2))+":";
		}
		return returnS.substring(0,returnS.length()-1);
	}
}
