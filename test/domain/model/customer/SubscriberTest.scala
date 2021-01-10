package domain.model.customer

import org.scalatestplus.play._

class SubscriberTest extends PlaySpec {

  "If you pass the Subscriber model arguments correctly, they will be stored in Valid" in {
    Subscriber.create(
      rawFirstName = "test",
      rawLastName  = "テスト"
    ).isValid mustBe true
  }

}
