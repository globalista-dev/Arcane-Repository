package com.globalista.arcrepo.util;

public class Helper {

    public static String formatName(String id) {
        String withoutNamespace = id.substring(id.indexOf(':') + 1);
        String[] parts = withoutNamespace.split("_");
        StringBuilder formattedName = new StringBuilder();

        for (String part : parts) {
            formattedName.append(Character.toUpperCase(part.charAt(0)))
                    .append(part.substring(1).toLowerCase())
                    .append(" ");
        }

        return formattedName.toString().trim();
    }

    public static String split(String id) {
        String withoutNamespace = id.substring(id.indexOf(':') + 1);

        String[] parts = withoutNamespace.split("_");
        return parts[parts.length - 1];
    }

}
