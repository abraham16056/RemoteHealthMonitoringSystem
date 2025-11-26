from rhms.models.patient import Patient
from rhms.models.heartrate import HeartRate
from rhms.models.bloodpressure import BloodPressure
from rhms.services.notification_service import NotificationService
from rhms.services.alert_service import AlertService
from rhms.services.monitoring_service import MonitoringService
import time

class Doctor:
    def __init__(self, doctor_id: str, name: str):
        self.doctor_id = doctor_id
        self.name = name

def run_simulation():
    notif = NotificationService()
    alert_svc = AlertService(notif)
    monitor = MonitoringService(alert_svc)
    dr_demir = Doctor("D001", "Demir")

    p1 = Patient("P001", "Ali Veli", 60, "+90500...")
    hr1 = HeartRate(int(time.time()), 72)
    monitor.receive_vital(p1, hr1, dr_demir)
    hr2 = HeartRate(int(time.time()), 130)
    monitor.receive_vital(p1, hr2, dr_demir)
    bp = BloodPressure(int(time.time()), 160, 100)
    monitor.receive_vital(p1, bp, dr_demir)

if __name__ == "__main__":
    run_simulation()