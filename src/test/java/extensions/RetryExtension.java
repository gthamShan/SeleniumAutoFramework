package extensions;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class RetryExtension implements TestExecutionExceptionHandler {
	private int retryCount = 0;
	private static final int MAX_RETRY_COUNT = 3;

	@Override
	public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
		if (retryCount < MAX_RETRY_COUNT) {
			retryCount++;
			context.getTestMethod().ifPresent(method -> {
				try {
					method.invoke(context.getTestInstance());
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			System.out.println("Retrying test " + context.getDisplayName() + " for the " + retryCount + " time.");
			throw throwable;
		}
		throw throwable;
	}

}
