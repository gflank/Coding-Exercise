import java.util.*;
import java.io.*;
import java.net.*;

public class Domain {
	public static List<String> getDomainsFromPage(List<String> page) {
		List<String> res = new ArrayList<>();
		if (page.size() == 0) return res;

		HashSet<String> domains = new HashSet<>();
		for (String line : page) {
			getDomainsFromLine(line, domains);
		}

		for (String domain : domains) {
			res.add(domain);
		}
		return res;
	}

	private static void getDomainsFromLine(String line, HashSet<String> domains) {
		// at least contains: href="http://"
		if (line.length() <= 14) return;
		List<String> urls = getURLsFromLine(line);
		for (String url : urls) {
			try {
				String host = (new URL(url)).getHost();
				// now check if host starts with www., web. or ww2.
				if (host.startsWith("www.") || host.startsWith("web.") || host.startsWith("ww2.")) {
					host = host.substring(4, host.length());
				}
				// check hashset and add
				if (!domains.contains(host)) {
					domains.add(host);
				}
			} catch (Exception e) {
				System.out.println("unknown format");
				continue;
			}
		}
	}

	private static List<String> getURLsFromLine(String line) {
		List<String> res = new ArrayList<String>();
		for (int i = 9; i < line.length(); ++i) {
			// valid URL should start with: href="http"
			if (line.substring(i - 9, i + 1).equals("href=\"http")) {
				// now check for the end of url
				int end = i + 1;
				while (end < line.length() && line.charAt(end) != '"') {
					++end;
				}
				// add content within ""
				res.add(line.substring(i - 3, end));
				// skip url part
				i = end;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		try {
			File file = new File("test2.html");
			Scanner scanner = new Scanner(file, "UTF-8");
			List<String> page = new ArrayList<>();
			while (scanner.hasNextLine()) {
				page.add(scanner.nextLine());
			}

			List<String> res = Domain.getDomainsFromPage(page);
			for (String cur : res) {
				System.out.println(cur);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}