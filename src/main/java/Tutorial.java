import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author FEIYST
 */
public class Tutorial {
	
	private static final transient Logger log = LoggerFactory.getLogger(Tutorial.class);
	
	public static void main(String[] args){
		log.info("My First Apache Shiro Application");

		//1.使用Shiro的IniSecurityManagerFactory实现来摄取shiro.ini
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		//2.factory.getInstance()调用该方法，该方法解析INI文件并返回SecurityManager反映配置的实例。
		SecurityManager securityManager = factory.getInstance();
		//3.通过JVM访问SecurityManager的静态（内存）单例(如果您在单个JVM中拥有多个启用Shiro的应用程序，则不希望这样做。)
		SecurityUtils.setSecurityManager(securityManager);

		System.exit(0);
	}
}