package InterfacesAndAbstraction.Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder builder = new StringBuilder();
        for (String url : urls) {
            if (isValidUrl(url)) {
                builder.append("Browsing: ").append(url).append("!");
            } else {
                builder.append("Invalid URL!");
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
        @Override
        public String call () {
            StringBuilder builder = new StringBuilder();
            for (String number : numbers) {
                if (isValidNumber(number)){
                    builder.append("Calling... ").append(number);
                }else {
                    builder.append("Invalid number!");
                }
                builder.append(System.lineSeparator());
            }
            return builder.toString().trim();

    }

    private boolean isValidNumber(String number) {
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    private boolean isValidUrl(String url) {
        for (char c : url.toCharArray()) {
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}