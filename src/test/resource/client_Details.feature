Feature: Save Client Details Feature

  Scenario: Capturing New Clients Details On The System
    Given I Have <Captured> New Clients Details
    When Click The <Save> Button
    Then Clients Details Must Be <Saved> Successfully