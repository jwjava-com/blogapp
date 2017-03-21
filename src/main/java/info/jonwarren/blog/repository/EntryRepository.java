/**
 * 
 */
package info.jonwarren.blog.repository;

import org.springframework.data.repository.CrudRepository;

import info.jonwarren.blog.data.Entry;

/**
 * 
 *
 * @author Jon Warren &lt;jon&#064;jonwarren.info&gt;
 */
public interface EntryRepository extends CrudRepository<Entry, Long> {

}
