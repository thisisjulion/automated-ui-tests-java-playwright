package com.funda;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectPackages("com.funda.tests.ui")
@IncludeTags("smoke")
@SuiteDisplayName("Smoke Test Suite")
public class SmokeSuiteRunner {}
