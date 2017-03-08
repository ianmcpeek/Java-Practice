package algorithms;

public class GoogleCode {

	public static int removeNumFromGroup(int nummy) {
		StringBuilder buff = new StringBuilder(Integer.toString(nummy));
		int max = Integer.MIN_VALUE;
		char prev = buff.charAt(0);
		for(int i = 1; i < buff.length(); i++) {
			char curr = buff.charAt(i);
			if(curr == prev) {
				buff.deleteCharAt(i);
				int remNum = Integer.parseInt(buff.toString());
				if(remNum > max) max = remNum;
				buff.insert(i, curr);
			} else {
				prev = curr;
			}
		}
		//first check if group, then check if min digit
		return max;
	}
	public static void main(String[] args) {
		int num = 44331122;
		System.out.println(removeNumFromGroup(num));
		System.out.println(num);
	}

}
