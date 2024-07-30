package party.msdg.work.base.user;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User one(@Param("account") String account);
    
    int add(User account);
}
