from abc import ABC, abstractmethod
from typing import Generic, TypeVar

T = TypeVar("T")

class Queue(ABC, Generic[T]):
  queue = []

  @abstractmethod
  def enqueue(self, item: T):
    self.queue.append(item);

  @abstractmethod
  def dequeue(self):
    self.queue.pop();