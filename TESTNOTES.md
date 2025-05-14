# Test Notes Assumptions and issues found

The purpose of this documentation is to provide additional info around the project,
any assumptions made when building the test suite and any potential issues and risks found and how I would address them within a live project lifecycle

## Assumptions:
- The project currently uses only two test data files provided (this could be extended to handle addition files in future)
- All vehicle data is expected to be for UK mainland registered cars with a standard registration format
  (two letters, followed by two numbers, followed by a space and then three letters)
- All non standard registration plate formats are out of scope for testing including but not limited to:

Q plates

Isle of Man (IOM) format

Republic of Ireland (ROI) format

Northern Ireland format

Guernsey format

any other registration formats that do not follow the standard UK convention
testingupdate


#  Issues found during testing:

- 1 - Discrepancy found between input data and output data: Ref registration BW57 BOW is detailed in the input file.
This yields an unknown vehicle in the application. The output data contains registration BW57 BOF which returns a known vehicle.

I handled this in the code by creating a cross check between the input and output registrations to ensure a match. If no match is found the vehicle details get set to unknown
which causes a failed test.

In a project setting I would attempt to avoid issues like this as early as possible by ensuring test data is thoroughly reviewed and corrected where
where  necessary as soon as possible in the project lifecycle.

Handling this scenario in the code as detailed above act as an additional measure to performing early reviews of data

- 2.
There are some discrepancies within the test data files with the format of the registration plates. For example some are written in the format:
KT17DLX while others appear in the format KT17 DLX.

This could also be handle in a similar fashion as described above but for large data sets or data that may be coming from an external source, the code ensures both input and output registrations are formatted
to the standard UK format (two letters, followed by two numbers, followed by a space and then three letters)

