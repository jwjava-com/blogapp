/**
 * 
 */
package info.jonwarren.blog.repository;

import org.springframework.data.repository.CrudRepository;

import info.jonwarren.blog.data.EntryStatus;

/**
 * 
 *
 * @author Jon Warren &lt;jon&#064;jonwarren.info&gt;
 */
public interface EntryStatusRepository extends CrudRepository<EntryStatus, Long> {

}
