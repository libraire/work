package party.msdg.work.database.source;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SourceDao {

    List<Source> all(@Param("userId") int userId);

    Source one(@Param("id") int id, @Param("userId") int userId);

    void add(Source source);
}
