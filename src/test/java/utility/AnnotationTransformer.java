package utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;


public class AnnotationTransformer implements IAnnotationTransformer{

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		
		if(testMethod==null) return;
		
	//	MaxRetryCount failureCount=testMethod.getAnnotation(MaxRetryCount.class);
	//	if(failureCount==null) return;
		annotation.setRetryAnalyzer(FailureRetryAnalyser.class);
		
		
		
		
	}

}
