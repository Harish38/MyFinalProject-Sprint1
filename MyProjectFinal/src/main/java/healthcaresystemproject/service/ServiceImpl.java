package healthcaresystemproject.service;

import java.sql.Date;

import healthcaresystemproject.dao.DaoImpl;
import healthcaresystemproject.dao.IDao;
import healthcaresystemproject.dto.DiagnosticCenter;
import healthcaresystemproject.dto.Test;
import healthcaresystemproject.dto.User;

public class ServiceImpl implements IService {
    IDao idao=new DaoImpl();
	public String addCenterService(DiagnosticCenter center) {
		
		return idao.addCenter(center);
	}

	public boolean removeCenterService(DiagnosticCenter center) {
		return idao.removeCenter(center);
	}

	public String addTestService(Test test) {
		return idao.addTest(test);
	}

	public boolean removeTestService(Test test) {
		return idao.removeTest(test);
	}

	public long makeAppointmentService(User user, DiagnosticCenter center, Test test, Date datetime) {
		return idao.makeAppointment(user, center, test, datetime);
	}

	public String registerService(User user) {
		return idao.register(user);
	}

	public boolean approveAppointment() {
		return idao.approveAppointment();
	}

}
