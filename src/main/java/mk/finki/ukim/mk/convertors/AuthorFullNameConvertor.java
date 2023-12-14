package mk.finki.ukim.mk.convertors;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;
import mk.finki.ukim.mk.model.AuthorFullName;

@Converter
public class AuthorFullNameConvertor implements AttributeConverter<AuthorFullName, String> {
    private static final String SEPARATOR = ", ";
    @Override
    public String convertToDatabaseColumn(AuthorFullName authorFullName) {
        if (authorFullName == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        if (authorFullName.getSurname() != null && !authorFullName.getSurname()
                .isEmpty()) {
            sb.append(authorFullName.getSurname());
            sb.append(SEPARATOR);
        }

        if (authorFullName.getName() != null
                && !authorFullName.getName().isEmpty()) {
            sb.append(authorFullName.getName());
        }

        return sb.toString();

    }

    @Override
    public AuthorFullName convertToEntityAttribute(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        String[] pieces = s.split(SEPARATOR);

        if (pieces == null || pieces.length == 0) {
            return null;
        }

        AuthorFullName fullname = new AuthorFullName();
        String firstPiece = !pieces[0].isEmpty() ? pieces[0] : null;
        if (s.contains(SEPARATOR)) {
            fullname.setSurname(firstPiece);

            if (pieces.length >= 2 && pieces[1] != null
                    && !pieces[1].isEmpty()) {
                fullname.setName(pieces[1]);
            }
        } else {
            fullname.setName(firstPiece);
        }

        return fullname;

    }
}
