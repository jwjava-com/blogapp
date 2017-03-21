/**
 * 
 */
package info.jonwarren.blog.repository;

import org.springframework.data.repository.CrudRepository;

import info.jonwarren.blog.data.Blog;

/**
 * 
 *
 * @author Jon Warren &lt;jon&#064;jonwarren.info&gt;
 */
public interface BlogRepository extends CrudRepository<Blog, Long> {

}
