package lesson.day0802.free;

public class Comparator implements java.util.Comparator<VO> {

	@Override
	public int compare(VO o1, VO o2) {
		// TODO Auto-generated method stub
		int result = o2.getData01() - o1.getData01();
		
		if(o2.getData01() == o1.getData01()) {
			result = o2.getStdNo() - o1.getStdNo();
		}
		return result;
	}

}
