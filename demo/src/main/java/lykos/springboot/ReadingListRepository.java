package lykos.springboot;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lykos on 2017/6/22.
 */
public interface ReadingListRepository extends JpaRepository<Book,Long>{
    List<Book> findByReader(String reader);
}
