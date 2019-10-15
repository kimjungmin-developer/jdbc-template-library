package nextstep.jdbc.queryexecutor;

import nextstep.jdbc.RowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateJdbcQueryExecutor implements JdbcQueryExecutor {
    private static final Logger log = LoggerFactory.getLogger(UpdateJdbcQueryExecutor.class);

    @Override
    public Boolean canHandle(String sql) {
        boolean truth = sql.startsWith("INSERT") || sql.startsWith("UPDATE");
        return truth;
    }

    @Override
    public Object execute(PreparedStatement ps, RowMapper rowMapper) {
        try {
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return null;
    }
}