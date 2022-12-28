package mk.finki.ukim.mk.lab.model.converter;

import mk.finki.ukim.mk.lab.model.attribute.UserFullName;

import javax.persistence.AttributeConverter;

import javax.persistence.Converter;

@Converter
public class UserFullNameConverter implements AttributeConverter<UserFullName,String> {
    private static final String SEPARATOR = ", ";

    @Override
    public String convertToDatabaseColumn(UserFullName userFullName) {
      if(userFullName == null){
          return null;
      }
      StringBuilder sb = new StringBuilder();
      if(userFullName.getSurname() !=null && !userFullName.getSurname()
              .isEmpty()){
          sb.append(userFullName.getSurname());
          sb.append(SEPARATOR);
      }
      if(userFullName.getName() !=null && !userFullName.getName().isEmpty()){
          sb.append(userFullName.getName());
      }
      return sb.toString();
    }

    @Override
    public UserFullName convertToEntityAttribute(String s) {
        if(s == null || s.isEmpty()){
            return null;
        }
        String [] pieces = s.split(SEPARATOR);

        if(pieces.length == 0 || pieces == null){
            return null;
        }
        UserFullName userFullName = new UserFullName();
        String firstPiece = !pieces[0].isEmpty() ? pieces[0]:null;
        if (s.contains(SEPARATOR)) {
           userFullName.setSurname(firstPiece);

            if (pieces.length >= 2 && pieces[1] != null
                    && !pieces[1].isEmpty()) {
                userFullName.setName(pieces[1]);
            }
        } else {
            userFullName.setName(firstPiece);
        }

        return userFullName;
    }
}
