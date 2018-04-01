package FirstClass;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean("processorAdd")
	public processorAdd getProcessorAdd() {
		return new processorAdd();
	}
	
	@Bean("processorMultiply")
	public processorMultiply getProcessorMul() {
		processorMultiply pMul = new processorMultiply();
		pMul.setAddInterface(getProcessorAdd());
		return pMul;
	}
	
	@Bean("processorMulAdd")
	public processorMulAdd getProcessorMulAdd() {
		processorMulAdd pMulAdd = new processorMulAdd();
		pMulAdd.setMulAddInterface(getProcessorAdd(), getProcessorMul());
		return pMulAdd;
	}
	
	@Bean("processorSub")
	public processorSubtract getProcessorSub() {
		return new processorSubtract();
	}
}
