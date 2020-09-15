
import java.util.*;
import java.util.stream.Collectors;

public class sourcecode {

	public static String[] torearranged(String s) {
		// TODO Auto-generated method stub
		String[] output = new String[2];
		if (s == null || s.length() == 0)
			return output;
		String res = "";
		int count = 0;
		String lowercase = s.toLowerCase();
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		LinkedHashMap<Character, String> map2 = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = lowercase.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			String temp="";
			if (map2.containsKey(ch)) {
				temp = map2.get(ch);
			}
			temp+=Character.toString(s.charAt(i));
			map2.put(ch, temp);
		}
		final Map<Character, Integer> sorted = map.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		for (char ch : sorted.keySet()) {
			if (count < 1) {
				output[1] = Character.toString(ch);
				count++;
			}
			res+= map2.get(ch);
		}
		output[0] = res;
		return output;
	}
}



