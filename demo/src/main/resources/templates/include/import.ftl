<#macro script filesMap={} >
    <#list filesMap?keys as path >
        <#assign fileNames =filesMap[path]>
        <#list fileNames?split(",") as file>
            <#if (file?trim)?has_content>
            <script type="text/javascript" src="${baseUrl}/${path}/${file}.js?version=${version}"></script>
            </#if>
        </#list>
    </#list>
</#macro>


<#macro link filesMap={}>
    <#list filesMap?keys as path >
        <#assign fileNames =filesMap[path]>
        <#list fileNames?split(",") as file>
            <#if (file?trim)?has_content>
            <link rel="stylesheet" type="text/css" href="${baseUrl}/${path}/${file}.css?version=${version}">
            </#if>
        </#list>
    </#list>
</#macro>

<#macro playloading>
<div class="modal fade" id="loadingModal" tabindex="-1" data-backdrop="false" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="loading">加载中……</div>
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</#macro>

