
package org.example.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddFileToRecord_QNAME = new QName("http://example.org/", "AddFileToRecord");
    private final static QName _AddFileToRecordResponse_QNAME = new QName("http://example.org/", "AddFileToRecordResponse");
    private final static QName _AddMark_QNAME = new QName("http://example.org/", "AddMark");
    private final static QName _AddMarkResponse_QNAME = new QName("http://example.org/", "AddMarkResponse");
    private final static QName _AddMarksToRecord_QNAME = new QName("http://example.org/", "AddMarksToRecord");
    private final static QName _AddMarksToRecordResponse_QNAME = new QName("http://example.org/", "AddMarksToRecordResponse");
    private final static QName _AddRecord_QNAME = new QName("http://example.org/", "AddRecord");
    private final static QName _AddRecordResponse_QNAME = new QName("http://example.org/", "AddRecordResponse");
    private final static QName _DeleteMark_QNAME = new QName("http://example.org/", "DeleteMark");
    private final static QName _DeleteMarkResponse_QNAME = new QName("http://example.org/", "DeleteMarkResponse");
    private final static QName _GetAllMarks_QNAME = new QName("http://example.org/", "GetAllMarks");
    private final static QName _GetAllMarksResponse_QNAME = new QName("http://example.org/", "GetAllMarksResponse");
    private final static QName _GetAllRecords_QNAME = new QName("http://example.org/", "GetAllRecords");
    private final static QName _GetAllRecordsResponse_QNAME = new QName("http://example.org/", "GetAllRecordsResponse");
    private final static QName _GetFileFromRecord_QNAME = new QName("http://example.org/", "GetFileFromRecord");
    private final static QName _GetFileFromRecordResponse_QNAME = new QName("http://example.org/", "GetFileFromRecordResponse");
    private final static QName _GetRecordsByMark_QNAME = new QName("http://example.org/", "GetRecordsByMark");
    private final static QName _GetRecordsByMarkResponse_QNAME = new QName("http://example.org/", "GetRecordsByMarkResponse");
    private final static QName _InitTestRecords_QNAME = new QName("http://example.org/", "InitTestRecords");
    private final static QName _InitTestRecordsResponse_QNAME = new QName("http://example.org/", "InitTestRecordsResponse");
    private final static QName _PrintAllRecords_QNAME = new QName("http://example.org/", "PrintAllRecords");
    private final static QName _PrintAllRecordsResponse_QNAME = new QName("http://example.org/", "PrintAllRecordsResponse");
    private final static QName _GetFileFromRecordResponseReturn_QNAME = new QName("", "return");
    private final static QName _AddFileToRecordArg2_QNAME = new QName("", "arg2");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Record }
     * 
     */
    public Record createRecord() {
        return new Record();
    }

    /**
     * Create an instance of {@link Record.Marks }
     * 
     */
    public Record.Marks createRecordMarks() {
        return new Record.Marks();
    }

    /**
     * Create an instance of {@link Record.RecordMarks }
     * 
     */
    public Record.RecordMarks createRecordRecordMarks() {
        return new Record.RecordMarks();
    }

    /**
     * Create an instance of {@link AddFileToRecord }
     * 
     */
    public AddFileToRecord createAddFileToRecord() {
        return new AddFileToRecord();
    }

    /**
     * Create an instance of {@link AddFileToRecordResponse }
     * 
     */
    public AddFileToRecordResponse createAddFileToRecordResponse() {
        return new AddFileToRecordResponse();
    }

    /**
     * Create an instance of {@link AddMark }
     * 
     */
    public AddMark createAddMark() {
        return new AddMark();
    }

    /**
     * Create an instance of {@link AddMarkResponse }
     * 
     */
    public AddMarkResponse createAddMarkResponse() {
        return new AddMarkResponse();
    }

    /**
     * Create an instance of {@link AddMarksToRecord }
     * 
     */
    public AddMarksToRecord createAddMarksToRecord() {
        return new AddMarksToRecord();
    }

    /**
     * Create an instance of {@link AddMarksToRecordResponse }
     * 
     */
    public AddMarksToRecordResponse createAddMarksToRecordResponse() {
        return new AddMarksToRecordResponse();
    }

    /**
     * Create an instance of {@link AddRecord }
     * 
     */
    public AddRecord createAddRecord() {
        return new AddRecord();
    }

    /**
     * Create an instance of {@link AddRecordResponse }
     * 
     */
    public AddRecordResponse createAddRecordResponse() {
        return new AddRecordResponse();
    }

    /**
     * Create an instance of {@link DeleteMark }
     * 
     */
    public DeleteMark createDeleteMark() {
        return new DeleteMark();
    }

    /**
     * Create an instance of {@link DeleteMarkResponse }
     * 
     */
    public DeleteMarkResponse createDeleteMarkResponse() {
        return new DeleteMarkResponse();
    }

    /**
     * Create an instance of {@link GetAllMarks }
     * 
     */
    public GetAllMarks createGetAllMarks() {
        return new GetAllMarks();
    }

    /**
     * Create an instance of {@link GetAllMarksResponse }
     * 
     */
    public GetAllMarksResponse createGetAllMarksResponse() {
        return new GetAllMarksResponse();
    }

    /**
     * Create an instance of {@link GetAllRecords }
     * 
     */
    public GetAllRecords createGetAllRecords() {
        return new GetAllRecords();
    }

    /**
     * Create an instance of {@link GetAllRecordsResponse }
     * 
     */
    public GetAllRecordsResponse createGetAllRecordsResponse() {
        return new GetAllRecordsResponse();
    }

    /**
     * Create an instance of {@link GetFileFromRecord }
     * 
     */
    public GetFileFromRecord createGetFileFromRecord() {
        return new GetFileFromRecord();
    }

    /**
     * Create an instance of {@link GetFileFromRecordResponse }
     * 
     */
    public GetFileFromRecordResponse createGetFileFromRecordResponse() {
        return new GetFileFromRecordResponse();
    }

    /**
     * Create an instance of {@link GetRecordsByMark }
     * 
     */
    public GetRecordsByMark createGetRecordsByMark() {
        return new GetRecordsByMark();
    }

    /**
     * Create an instance of {@link GetRecordsByMarkResponse }
     * 
     */
    public GetRecordsByMarkResponse createGetRecordsByMarkResponse() {
        return new GetRecordsByMarkResponse();
    }

    /**
     * Create an instance of {@link InitTestRecords }
     * 
     */
    public InitTestRecords createInitTestRecords() {
        return new InitTestRecords();
    }

    /**
     * Create an instance of {@link InitTestRecordsResponse }
     * 
     */
    public InitTestRecordsResponse createInitTestRecordsResponse() {
        return new InitTestRecordsResponse();
    }

    /**
     * Create an instance of {@link PrintAllRecords }
     * 
     */
    public PrintAllRecords createPrintAllRecords() {
        return new PrintAllRecords();
    }

    /**
     * Create an instance of {@link PrintAllRecordsResponse }
     * 
     */
    public PrintAllRecordsResponse createPrintAllRecordsResponse() {
        return new PrintAllRecordsResponse();
    }

    /**
     * Create an instance of {@link Mark }
     * 
     */
    public Mark createMark() {
        return new Mark();
    }

    /**
     * Create an instance of {@link Record.Marks.Entry }
     * 
     */
    public Record.Marks.Entry createRecordMarksEntry() {
        return new Record.Marks.Entry();
    }

    /**
     * Create an instance of {@link Record.RecordMarks.Entry }
     * 
     */
    public Record.RecordMarks.Entry createRecordRecordMarksEntry() {
        return new Record.RecordMarks.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFileToRecord }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddFileToRecord }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "AddFileToRecord")
    public JAXBElement<AddFileToRecord> createAddFileToRecord(AddFileToRecord value) {
        return new JAXBElement<AddFileToRecord>(_AddFileToRecord_QNAME, AddFileToRecord.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFileToRecordResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddFileToRecordResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "AddFileToRecordResponse")
    public JAXBElement<AddFileToRecordResponse> createAddFileToRecordResponse(AddFileToRecordResponse value) {
        return new JAXBElement<AddFileToRecordResponse>(_AddFileToRecordResponse_QNAME, AddFileToRecordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMark }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddMark }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "AddMark")
    public JAXBElement<AddMark> createAddMark(AddMark value) {
        return new JAXBElement<AddMark>(_AddMark_QNAME, AddMark.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMarkResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddMarkResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "AddMarkResponse")
    public JAXBElement<AddMarkResponse> createAddMarkResponse(AddMarkResponse value) {
        return new JAXBElement<AddMarkResponse>(_AddMarkResponse_QNAME, AddMarkResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMarksToRecord }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddMarksToRecord }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "AddMarksToRecord")
    public JAXBElement<AddMarksToRecord> createAddMarksToRecord(AddMarksToRecord value) {
        return new JAXBElement<AddMarksToRecord>(_AddMarksToRecord_QNAME, AddMarksToRecord.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMarksToRecordResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddMarksToRecordResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "AddMarksToRecordResponse")
    public JAXBElement<AddMarksToRecordResponse> createAddMarksToRecordResponse(AddMarksToRecordResponse value) {
        return new JAXBElement<AddMarksToRecordResponse>(_AddMarksToRecordResponse_QNAME, AddMarksToRecordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddRecord }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddRecord }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "AddRecord")
    public JAXBElement<AddRecord> createAddRecord(AddRecord value) {
        return new JAXBElement<AddRecord>(_AddRecord_QNAME, AddRecord.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddRecordResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddRecordResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "AddRecordResponse")
    public JAXBElement<AddRecordResponse> createAddRecordResponse(AddRecordResponse value) {
        return new JAXBElement<AddRecordResponse>(_AddRecordResponse_QNAME, AddRecordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMark }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteMark }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "DeleteMark")
    public JAXBElement<DeleteMark> createDeleteMark(DeleteMark value) {
        return new JAXBElement<DeleteMark>(_DeleteMark_QNAME, DeleteMark.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMarkResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteMarkResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "DeleteMarkResponse")
    public JAXBElement<DeleteMarkResponse> createDeleteMarkResponse(DeleteMarkResponse value) {
        return new JAXBElement<DeleteMarkResponse>(_DeleteMarkResponse_QNAME, DeleteMarkResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllMarks }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllMarks }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "GetAllMarks")
    public JAXBElement<GetAllMarks> createGetAllMarks(GetAllMarks value) {
        return new JAXBElement<GetAllMarks>(_GetAllMarks_QNAME, GetAllMarks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllMarksResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllMarksResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "GetAllMarksResponse")
    public JAXBElement<GetAllMarksResponse> createGetAllMarksResponse(GetAllMarksResponse value) {
        return new JAXBElement<GetAllMarksResponse>(_GetAllMarksResponse_QNAME, GetAllMarksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllRecords }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllRecords }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "GetAllRecords")
    public JAXBElement<GetAllRecords> createGetAllRecords(GetAllRecords value) {
        return new JAXBElement<GetAllRecords>(_GetAllRecords_QNAME, GetAllRecords.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllRecordsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllRecordsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "GetAllRecordsResponse")
    public JAXBElement<GetAllRecordsResponse> createGetAllRecordsResponse(GetAllRecordsResponse value) {
        return new JAXBElement<GetAllRecordsResponse>(_GetAllRecordsResponse_QNAME, GetAllRecordsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFileFromRecord }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFileFromRecord }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "GetFileFromRecord")
    public JAXBElement<GetFileFromRecord> createGetFileFromRecord(GetFileFromRecord value) {
        return new JAXBElement<GetFileFromRecord>(_GetFileFromRecord_QNAME, GetFileFromRecord.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFileFromRecordResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFileFromRecordResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "GetFileFromRecordResponse")
    public JAXBElement<GetFileFromRecordResponse> createGetFileFromRecordResponse(GetFileFromRecordResponse value) {
        return new JAXBElement<GetFileFromRecordResponse>(_GetFileFromRecordResponse_QNAME, GetFileFromRecordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecordsByMark }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetRecordsByMark }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "GetRecordsByMark")
    public JAXBElement<GetRecordsByMark> createGetRecordsByMark(GetRecordsByMark value) {
        return new JAXBElement<GetRecordsByMark>(_GetRecordsByMark_QNAME, GetRecordsByMark.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecordsByMarkResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetRecordsByMarkResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "GetRecordsByMarkResponse")
    public JAXBElement<GetRecordsByMarkResponse> createGetRecordsByMarkResponse(GetRecordsByMarkResponse value) {
        return new JAXBElement<GetRecordsByMarkResponse>(_GetRecordsByMarkResponse_QNAME, GetRecordsByMarkResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitTestRecords }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InitTestRecords }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "InitTestRecords")
    public JAXBElement<InitTestRecords> createInitTestRecords(InitTestRecords value) {
        return new JAXBElement<InitTestRecords>(_InitTestRecords_QNAME, InitTestRecords.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitTestRecordsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InitTestRecordsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "InitTestRecordsResponse")
    public JAXBElement<InitTestRecordsResponse> createInitTestRecordsResponse(InitTestRecordsResponse value) {
        return new JAXBElement<InitTestRecordsResponse>(_InitTestRecordsResponse_QNAME, InitTestRecordsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintAllRecords }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PrintAllRecords }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "PrintAllRecords")
    public JAXBElement<PrintAllRecords> createPrintAllRecords(PrintAllRecords value) {
        return new JAXBElement<PrintAllRecords>(_PrintAllRecords_QNAME, PrintAllRecords.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintAllRecordsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PrintAllRecordsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://example.org/", name = "PrintAllRecordsResponse")
    public JAXBElement<PrintAllRecordsResponse> createPrintAllRecordsResponse(PrintAllRecordsResponse value) {
        return new JAXBElement<PrintAllRecordsResponse>(_PrintAllRecordsResponse_QNAME, PrintAllRecordsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     */
    @XmlElementDecl(namespace = "", name = "return", scope = GetFileFromRecordResponse.class)
    public JAXBElement<byte[]> createGetFileFromRecordResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_GetFileFromRecordResponseReturn_QNAME, byte[].class, GetFileFromRecordResponse.class, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     */
    @XmlElementDecl(namespace = "", name = "arg2", scope = AddFileToRecord.class)
    public JAXBElement<byte[]> createAddFileToRecordArg2(byte[] value) {
        return new JAXBElement<byte[]>(_AddFileToRecordArg2_QNAME, byte[].class, AddFileToRecord.class, ((byte[]) value));
    }

}
