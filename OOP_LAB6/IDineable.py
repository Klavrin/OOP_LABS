from abc import ABC, abstractmethod

class Dineable(ABC):
  @abstractmethod
  def serveDinner(carId):
    pass
