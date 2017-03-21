/**
 * 
 */
package info.jonwarren.blog.repository;

import org.springframework.data.repository.CrudRepository;

import info.jonwarren.blog.data.Tag;

/**
 * 
 *
 * @author Jon Warren &lt;jon&#064;jonwarren.info&gt;
 */
public interface TagRepository extends CrudRepository<Tag, Long> {

}
