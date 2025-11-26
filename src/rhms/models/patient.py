from typing import List
from rhms.models.device import Device
from rhms.models.vitalsign import VitalSign

class Patient:
    def __init__(self, patient_id: str, name: str, age: int, phone: str):
        self.id = patient_id
        self.name = name
        self.age = age
        self.phone = phone
        self.devices: List[Device] = []
        self.vitals: List[VitalSign] = []

    def add_device(self, device: Device):
        self.devices.append(device)

    def record_vital(self, vital: VitalSign):
        self.vitals.append(vital)