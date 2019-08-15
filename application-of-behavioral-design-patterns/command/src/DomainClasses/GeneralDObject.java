

package DomainClasses;



import java.sql.*;


public interface GeneralDObject
{ String getAtrValue();
  String setAtrValue();
  String getClassName();
  String getWhereCondition();
  String getNameByColumn(int column);
  GeneralDObject getNewRecord(ResultSet rs) throws SQLException;
}
