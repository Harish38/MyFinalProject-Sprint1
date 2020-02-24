package healthcaresystemproject.service;

import java.sql.Date;

import healthcaresystemproject.dto.DiagnosticCenter;
import healthcaresystemproject.dto.Test;
import healthcaresystemproject.dto.User;

public interface IService {
		public String addCenterService(DiagnosticCenter center);
		public boolean removeCenterService(DiagnosticCenter center);
		public String addTestService(Test test);
		public boolean removeTestService(Test test);
		public long makeAppointmentService(User user,DiagnosticCenter center,Test test,Date datetime);
		public String registerService(User user);
		public boolean approveAppointment();
}
