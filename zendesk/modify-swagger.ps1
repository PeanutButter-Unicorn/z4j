#Requires -Module PowerShell-YAML

function ConvertDocsToHtml {
    param(
        [Parameter(Mandatory = $true)]
        [Alias('f')]
        [ValidateScript({
                Test-Path -Path $_
            })]
        [string] $File
    )

    $content = ConvertFrom-Yaml(Get-Content -Path $File -Raw)

    $content.paths.keys | ForEach-Object {
        $path = $_
        $content.paths[$_] | ForEach-Object {
            $_.keys | % {
                if ($_ -eq "parameters") { Write-Debug "skipping" }
                else {
                    try
                    {
                        $content.paths[$path][$_].description = ConvertFrom-Markdown  -inputObject ($content.paths[$path][$_].description)
                    }
                    catch
                    {
                        Write-Debug "failed to convert $_ object"
                    }

                }
            }
        }
    }
    Convertto-Yaml $content -Options JsonCompatible | Out-File "$(Split-Path $file -Parent -Resolve)\modified-$(Split-Path $File -Leaf -Resolve)"
}